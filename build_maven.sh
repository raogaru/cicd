MARKER "script:build_maven.sh START"

ECHO "building jar using maven"

java -cp target/myapp-1.0.jar com.raogaru.app.App

MARKER "script:build_maven.sh END"
