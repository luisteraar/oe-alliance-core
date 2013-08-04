DESCRIPTION = "Inittab for sysvinit"

require conf/license/license-gplv2.inc

PR = "r7"

SRC_URI = "file://inittab"

S = "${WORKDIR}/sysvinit-${PV}"

INHIBIT_DEFAULT_DEPS = "1"

do_compile() {
	:
}

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
}
