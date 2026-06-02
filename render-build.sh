#!/bin/bash
set -e

# Download and install Maven
MAVEN_VERSION="3.9.6"
MAVEN_URL="https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz"

echo "Installing Maven..."
cd /tmp
curl -s -o maven.tar.gz $MAVEN_URL
tar -xzf maven.tar.gz
export PATH=$PATH:/tmp/apache-maven-${MAVEN_VERSION}/bin

# Set JAVA_HOME - try multiple locations
if [ -z "$JAVA_HOME" ]; then
  if [ -d "/usr/lib/jvm/java-17-openjdk-amd64" ]; then
    export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
  elif [ -d "/usr/lib/jvm/java-11-openjdk-amd64" ]; then
    export JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"
  else
    export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java) 2>/dev/null) 2>/dev/null) 2>/dev/null) || true
  fi
fi

echo "JAVA_HOME: $JAVA_HOME"
java -version

# Build the project
echo "Building Spring Boot application..."
cd /app
mvn clean install -DskipTests -q

echo "Build complete!"
