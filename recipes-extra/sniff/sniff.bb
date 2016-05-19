SUMMARY = "sniffer app component"
HOMEPAGE = "http://github.com/s-maynard/sniff"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "pcd8544 libwitutil libwit"

SRC_URI = "\
    git://github.com/s-maynard/sniff.git;branch=master \
    "
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} = " \
    /usr/bin/sniff \
"
