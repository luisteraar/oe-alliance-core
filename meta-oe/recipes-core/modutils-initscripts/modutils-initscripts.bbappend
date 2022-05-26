S = "${WORKDIR}/src"

PR = "r8"

do_install:append () {
	sed -i 's!LOAD_MODULE=modprobe!LOAD_MODULE="modprobe --force-modversion"!g' ${D}${sysconfdir}/init.d/modutils.sh
}

python do_unpack:append() {
    import shutil
    shutil.copy("modutils.sh", "src/modutils.sh")
}

INITSCRIPT_NAME = "modutils.sh"
INITSCRIPT_PARAMS = "start 04 S ."
