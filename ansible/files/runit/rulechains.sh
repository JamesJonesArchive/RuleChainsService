#!/bin/sh
# `/sbin/setuser memcache` runs the given command as the user `memcache`.
# If you omit that part, the command will be run as root.
# exec /sbin/setuser memcache /usr/bin/memcached >>/var/log/memcached.log 2>&1

exec source /etc/sysconfig/rulechains; /usr/bin/java -Dgrails.env=prod -jar /usr/local/lib/rulechains/RuleChains.jar --spring.config.name=$SPRING_CONFIG_NAME --server.port=$SERVER_PORT --spring.config.location=$SPRING_CONFIG_LOCATION