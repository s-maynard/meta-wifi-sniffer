FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://syslog-ng.conf"

do_install_append() {
    install -d ${D}${sysconfdir}/${PN}
    install -m 0755 ${WORKDIR}/${PN}.conf ${D}${sysconfdir}/${PN}/
}

FILES_${PN} += "\
    ${sysconfdir}/${PN}/${PN}.conf \
"
