#!/bin/bash
set -e

# Install Java 17 if not available
if ! command -v java &> /dev/null; then
  echo "Java not found, installing OpenJDK 17..."
  JDK_URL="https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.10%2B7/OpenJDK17U-jdk_x64_linux_hotspot_17.0.10_7.tar.gz"
  cd /tmp
  curl -L -o jdk.tar.gz "$JDK_URL"
  tar -xzf jdk.tar.gz
  export JAVA_HOME="/tmp/jdk-17.0.10+7"
  export PATH="$JAVA_HOME/bin:$PATH"
  echo "Java installed: $(java -version 2>&1 | head -1)"
else
  if [ -z "$JAVA_HOME" ]; then
    export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))
  fi
fi

echo "JAVA_HOME: $JAVA_HOME"
java -version

# Install Maven
MAVEN_VERSION="3.9.6"
MAVEN_URL="https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz"

echo "Installing Maven..."
cd /tmp
curl -s -o maven.tar.gz "$MAVEN_URL"
tar -xzf maven.tar.gz
export PATH="$PATH:/tmp/apache-maven-${MAVEN_VERSION}/bin"

echo "Maven installed: $(mvn -version 2>&1 | head -1)"

# Build the project
echo "Building Spring Boot application..."
cd /app
mvn clean install -DskipTests -q

echo "Build complete!"
