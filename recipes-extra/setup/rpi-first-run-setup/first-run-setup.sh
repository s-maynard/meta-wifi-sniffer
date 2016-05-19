#!/bin/sh

# Initially based on the scripts by JohnX/Mer Project - http://wiki.maemo.org/Mer/
# Reworked for the OpenPandora - John Willis/Michael Mrozek
# Quickly 'hacked' for the Raspberry Pi to provide a simple 1st boot wizard.

# Modified by - Carey Sonsino

# Ensure there is a wheel group for sudoers to be put into.
# TODO: Do this somewhere better.
groupadd wheel

# Set the root password
rootusername="root"
rootpassword="raspiroot"
passwd "$rootusername" <<EOF
$rootpassword
$rootpassword
EOF

# Set up the user account
fullname="raspberry pi"
username="pi"
password="raspberry"

useradd -c "$fullname,,," -G wheel,users "$username"

passwd "$username" <<EOF
$password
$password
EOF

# Add the new user to the sudoers list
echo "$username ALL=(ALL:ALL) ALL" >> /etc/sudoers

# Update the environment PATH
# Note - /sbin and /usr/sbin are only added to the path for the root user.  The following
# export adds those directories for the newly added user
echo "export PATH=$PATH" >> /home/$username/.bashrc
echo "alias l='ls -CF'" >> /home/$username/.bashrc
echo "alias la='ls -A'" >> /home/$username/.bashrc
echo "alias ll='ls -alF'" >> /home/$username/.bashrc


# Lock the root account
usermod -L "$rootusername"

# Pick a name for the machine.

hostname="sniffer"
hostname_file="/etc/hostname"
hosts_file="/etc/hosts"

echo $hostname > $hostname_file
hostname =$(sed 's/ /_/g' $hostname_file)
echo $hostname > $hostname_file
echo "127.0.0.1 localhost.localdomain localhost $hostname" > $hosts_file
hostname -F $hosts_file

control_file="/etc/rpi/first-boot"

# Write the control file so this script is not run on next boot 
# (hackish I know but I want the flexability to drop a new script in later esp. in the early firmwares).

touch $control_file
# Prevent the control file from being erased, which would rerun the initial setup on next boot
chmod 0444 $control_file

# Remove THIS script (especially since it contains sensitive info)
rm -f $0

reboot

