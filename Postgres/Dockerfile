FROM postgres:latest

COPY pg_hba.conf /custom-config/pg_hba.conf

COPY init.sh /docker-entrypoint-initdb.d/init.sh

RUN chmod +x /docker-entrypoint-initdb.d/init.sh

ENV PGDATA=/var/lib/postgresql/data/pgdata