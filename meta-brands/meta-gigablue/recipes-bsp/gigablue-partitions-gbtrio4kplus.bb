SUMMARY = "${MACHINEBUILD} partitions files"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc
PACKAGE_ARCH = "${MACHINEBUILD}"

inherit deploy

SRCDATE = "20221212"
PR = "${SRCDATE}"

S = "${WORKDIR}/partitions"

SRC_URI = "https://source.mynonpublic.com/gigablue/mv200/${MACHINEBUILD}-partitions-${SRCDATE}.zip \
  file://flash-apploader \
"

inherit update-rc.d

INITSCRIPT_NAME = "flash-apploader"
INITSCRIPT_PARAMS = "start 90 S ."

ALLOW_EMPTY:${PN} = "1"
do_configure[nostamp] = "1"

do_install() {
    install -d ${D}/usr/share
    install -m 0644 ${S}/bootargs.bin ${D}/usr/share/bootargs.bin
    install -m 0644 ${S}/fastboot.bin ${D}/usr/share/fastboot.bin
    install -m 0644 ${S}/apploader.bin ${D}/usr/share/apploader.bin
    install -m 0755 -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/flash-apploader ${D}${sysconfdir}/init.d/flash-apploader
}

FILES:${PN} = "/usr/share ${sysconfdir}"

do_deploy() {
    install -d ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
    install -m 0755 ${S}/bootargs.bin ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
    install -m 0755 ${S}/boot.img ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
    install -m 0755 ${S}/fastboot.bin ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
    install -m 0755 ${S}/apploader.bin ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
    install -m 0755 ${S}/pq_param.bin ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
    install -m 0755 ${S}/emmc_partitions.xml ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
    install -m 0755 ${S}/baseparam.img ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
    install -m 0755 ${S}/logo.img ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
    install -m 0755 ${S}/deviceinfo.bin ${DEPLOY_DIR_IMAGE}/${MACHINEBUILD}-partitions
}

addtask deploy before do_package after do_install

SRC_URI[md5sum] = "de6aa2bc90b436aa1722cff7af1cfd4e"
SRC_URI[sha256sum] = "3c16a09d628cfe35e3a0c09426b0d34eb163b9c30774d97b835e3ba95d835720"

INSANE_SKIP:${PN} += "already-stripped"
