# Run your simulator specifically (shortcut command)
simulator: compile
	@docker exec -it java8-compiler java com.avaj.simulator.Simulator scenario.txt

.PHONY: all clean compile run start stop view-output run-app

# Default target
all: compile

# Start the Docker container
start:
	docker-compose up -d

# Stop the Docker container
stop:
	docker-compose down

# Clean compiled files
clean:
	docker exec -it java8-compiler sh -c "find . -name \"*.class\" -delete"

# Compile all Java files
compile: start
	docker exec -it java8-compiler sh -c "find * -name \"*.java\" > sources.txt && javac @sources.txt"
