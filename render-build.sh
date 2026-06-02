#!/bin/bash
# Download and install Maven
MAVEN_VERSION="3.9.6"
MAVEN_URL="https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz"

echo "Installing Maven..."
cd /tmp
curl -o maven.tar.gz $MAVEN_URL
tar -xzf maven.tar.gz
export PATH=$PATH:/tmp/apache-maven-${MAVEN_VERSION}/bin
export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))

# Build the project
echo "Building Spring Boot application..."
cd $1
mvn clean install -DskipTests

echo "Build complete!"
