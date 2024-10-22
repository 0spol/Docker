#!/bin/bash
set -e

if [ -f "$PGDATA/pg_hba.conf" ]; then
    mv "$PGDATA/pg_hba.conf" "$PGDATA/pg_hba_old.conf"
    cp /custom-config/pg_hba.conf "$PGDATA/pg_hba.conf"
fi

exec "$@"