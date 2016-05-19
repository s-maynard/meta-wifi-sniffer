SUMMARY = "Custom package group for Wireless Information Tool"

LICENSE = "MIT"

inherit packagegroup


PACKAGES = "\
    packagegroup-sniffer \
    packagegroup-sniffer-debug \
"

# Components used in sniffer
RDEPENDS_packagegroup-sniffer = "\
    systemd-compat-units \
    linux-firmware \
    linux-firmware-brcm43430 \
    linux-firmware-ralink \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    psplash \
    telnetd \
    sshd \
    iperf3 \
    cronie \
    parted \
    binutils \
    binutils-symlinks \
    coreutils \
    bridge-utils \
    iw \
    networkmanager \
    wireless-tools \
    wpa-supplicant \
    wlan-ctl \
    less \
    ntp \
    ntpdate \
    openssh \
    perl \
    perl-modules \
    python-dev \
    python-imaging \
    python-modules \
    syslog-ng \
    sniff \
    sniffer-app-ctl \
"

# Components used in debug sniffer
RDEPENDS_packagegroup-sniffer-debug = "\
    git \
    autoconf \
    automake \
    cpp \
    cpp-symlinks \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    make \
    pkgconfig \
    ldd \
    libtool \
    libstdc++ \
    libstdc++-dev \
    diffutils \
    gdb \
    gdbserver \
    ctags \
    vim-tiny \
"

#Note: psplash is not required, but it adds a nice "yocto project" splash screen and loading bar

