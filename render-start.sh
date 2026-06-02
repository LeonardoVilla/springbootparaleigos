#!/bin/bash
set -e

# Install Java 17 if not available
if ! command -v java &> /dev/null; then
  if [ -d "/tmp/jdk-17.0.10+7" ]; then
    export JAVA_HOME="/tmp/jdk-17.0.10+7"
    export PATH="$JAVA_HOME/bin:$PATH"
  else
    echo "Java not found, installing OpenJDK 17..."
    JDK_URL="https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.10%2B7/OpenJDK17U-jdk_x64_linux_hotspot_17.0.10_7.tar.gz"
    cd /tmp
    curl -L -o jdk.tar.gz "$JDK_URL"
    tar -xzf jdk.tar.gz
    export JAVA_HOME="/tmp/jdk-17.0.10+7"
    export PATH="$JAVA_HOME/bin:$PATH"
    cd -
  fi
fi

echo "Starting app with Java: $(java -version 2>&1 | head -1)"
exec java -Dserver.port=$PORT -jar target/escola-alunos-1.0.0.jar
