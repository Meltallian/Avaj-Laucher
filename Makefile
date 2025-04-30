# Makefile for Java 8 Docker compilation

.PHONY: all clean compile run start stop view-output

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
	@echo "Compilation complete!"

# Run a specific class (usage: make run CLASS=YourClassName)
run: start
	@if [ -z "$(CLASS)" ]; then \
		echo "Error: Please specify a class name with CLASS=YourClassName"; \
		exit 1; \
	fi
	docker exec -it java8-compiler java $(CLASS)

# View simulation output file
view: start
	@docker exec -it java8-compiler sh -c "if [ -f simulation.txt ]; then cat simulation.txt; else echo 'Error: simulation.txt not found'; fi"