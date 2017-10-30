require recipes-mediacenter/kodi/stb-kodi_${PV}.bb

PROVIDES += "virtual/kodi"
RPROVIDES_${PN} += "virtual/kodi"
PROVIDES += "kodi"
RPROVIDES_${PN} += "kodi"

EXTRA_OECONF += " \
    --with-platform=nextv-cortexa15 \
    --with-ffmpeg=v3d \
"

INSANE_SKIP_${PN} += "file-rdeps"
