SUMMARY = "libWIT component"
HOMEPAGE = "http://github.com/s-maynard/libwit.git"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "libnl libwitutil"

SRC_URI = "\
    git://github.com/s-maynard/libwit.git;branch=master \
    "
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit autotools
