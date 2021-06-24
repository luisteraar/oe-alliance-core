SUMMARY = "Open Source Qt WebEngine HbbTV Browser Extension"
PACKAGE_ARCH := "${MACHINE_ARCH}"
LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
file://__init__.py;md5=d41d8cd98f00b204e9800998ecf8427e \
"

RDEPENDS_${PN} = "openhbbtvbrowser"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r1"

SRC_URI = "git://github.com/openhbbtvbrowser/enigma2-plugin-extensions-openhbbtvbrowser.git;protocol=git \
    ${@bb.utils.contains_any("SOC_FAMILY", "hisi3716mv430 hisi3798mv200 hisi3716mv410 hisi3798mv310", "file://eglfs.patch", "", d)} \
"

S = "${WORKDIR}/git"

do_install(){
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/HbbTV
    install -m 0755 ${S}/*.py ${D}${libdir}/enigma2/python/Plugins/Extensions/HbbTV
}

FILES_${PN} = "${libdir}"
