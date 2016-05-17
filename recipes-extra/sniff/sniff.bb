SUMMARY = "sniffer app component"
HOMEPAGE = "http://github.com/s-maynard/sniff"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=d41d8cd98f00b204e9800998ecf8427e"

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
