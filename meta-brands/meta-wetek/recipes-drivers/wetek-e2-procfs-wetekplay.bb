SUMMARY = "Wetek Enigma2 procfs drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

KV = "3.10.93"
SRCDATE = "20160415"

PV = "${KV}+${SRCDATE}"
PR = "r1"

SRC_URI = "file://wetek-e2-procfs-${KV}-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_compile() {
}
do_populate_sysroot() {
}

do_install() {
    install -d ${D}${base_libdir}/modules/${KV}/extra
    install -m 0755 ${WORKDIR}/e2-procfs.ko ${D}${base_libdir}/modules/${KV}/extra/
}


FILES_${PN} += "/lib/modules/${KV}/extra"