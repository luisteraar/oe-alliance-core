SUMMARY = "OPTI-Combo DVB-T2/C USB Stick"
PACKAGE_ARCH = "all"

require conf/license/license-gplv2.inc

DVBSKYPROVIDER ?= "dvb-sky"

RRECOMMENDS_${PN} = " \
    ${@bb.utils.contains("MACHINE_FEATURES", "legacykernel", "", " \
    ${DVBSKYPROVIDER}-module-dvb-usb-dvbsky \
    ${DVBSKYPROVIDER}-module-dvb-usb-v2 \
    ${DVBSKYPROVIDER}-module-m88ds3103 \
    ${DVBSKYPROVIDER}-module-dvbsky-m88ds3103 \
    ${DVBSKYPROVIDER}-module-dvbsky-m88rs6000 \
    ${DVBSKYPROVIDER}-module-sit2fe \
    ${DVBSKYPROVIDER}-module-si2168 \
    ${DVBSKYPROVIDER}-module-si2157 \
    firmware-dvb-usb-s660 \
    firmware-dvb-fe-ds3000 \
    firmware-dvb-fe-ds3xxx \
    firmware-dvb-fe-si2168 \
    ", d)}"

PV = "2.0"
PR = "r7"

ALLOW_EMPTY_${PN} = "1"
