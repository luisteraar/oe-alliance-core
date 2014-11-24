SUMMARY = "Merge machine and distro options to create a enigma2 feeds machine task/package"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

ALLOW_EMPTY_${PN} = "1"
PACKAGES = "${PN}"

PV = "1.0"
PR = "r15"

RRECOMMENDS_${PN} = "\
    oe-alliance-skins \
    enigma2-display-skins \
    openvix-softcams-meta \
    openvix-bootlogos-meta \
	${@base_contains("MACHINE_FEATURES", "skins1080", "enigma2-plugin-vixhd-skins", "", d)} \
    "