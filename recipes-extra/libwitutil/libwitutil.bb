SUMMARY = "libWITutils component"
HOMEPAGE = "http://github.com/s-maynard/libwitutil.git"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "libnl"

SRC_URI = "\
    git://github.com/s-maynard/libwitutil.git;branch=master \
    "
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit autotools

do_install_append () {
    install -m 777 ${S}/src/witutil.h -t ${D}/usr/include
}

FILES_${PN} = " \
    /usr/include/witutil.h \
    /usr/lib/libwitutil.so.* \
"
