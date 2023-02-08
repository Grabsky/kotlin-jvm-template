> **Warning**  
> This template is outdated and now archived.

### Setup Guide
1. Clone the repository: `git clone https://github.com/Grabsky/kotlin-jvm-template`
2. Save as IntelliJ IDEA template: `File > New Projects Setup > Save Project as Template...`
3. Create a project using new Template.

### Building
Building the project is as easy as executing `gradle assemble` or `gradle clean assemble` command.
Produced artifacts are copied to `{DEVELOPMENT_DIR}/builds` or `./builds` directory in case `DEVELOPMENT_DIR` environment variable does not exist.
