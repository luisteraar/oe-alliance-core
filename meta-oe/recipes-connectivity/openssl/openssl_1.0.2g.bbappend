FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR .= ".5"

PACKAGE_ARCH := "${MACHINE_ARCH}"

SRC_URI_append = " file://fix_openssl_100_version.patch"

SRC_URI_append_openbh = " file://fix_openssl_100_version_jethro.patch"
SRC_URI_append_openvix = " file://fix_openssl_100_version_jethro.patch"
