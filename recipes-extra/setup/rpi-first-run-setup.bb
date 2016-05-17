DESCRIPTION = "Scripts to support a first run setup on the Raspberry Pi."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

#COMPATIBLE_MACHINE = "raspberrypi raspberrypi2"

RDEPENDS_${PN} = "sudo"

SRC_URI = " \
    file://LICENSE \
    file://first-run-setup.sh \
    file://rpi_startup.sh \
    file://rc.firstrun \
"

inherit update-rc.d

INITSCRIPT_NAME = "rpi-run-init"
INITSCRIPT_PARAMS = "start 29 2 3 4 5 . stop  29 2 3 4 5 ."

do_install() {
    install -d ${D}${prefix}/rpi/scripts/
    install -m 0755 ${WORKDIR}/first-run-setup.sh ${D}${prefix}/rpi/scripts/
    install -m 0755 ${WORKDIR}/rpi_startup.sh ${D}${prefix}/rpi/scripts/

    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/rc.firstrun ${D}${sysconfdir}/init.d/rpi-run-init

    install -d ${D}${sysconfdir}/rpi/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "\
    ${prefix} \
    ${sysconfdir} \
"

