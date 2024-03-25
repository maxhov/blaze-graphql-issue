# Blaze Persistence Graphql Inheritence issue

Project was generated with:
`mvn archetype:generate "-DarchetypeGroupId=com.blazebit" "-DarchetypeArtifactId=blaze-persistence-archetype-spring-boot-sample" "-DarchetypeVersion=1.6.11"`

### How to run

Run the `SampleTest` test class in this project. It will query the Graphql endpoint for cats (parent
type) and colored cats (subtype). It will error on Cats and succeed on ColoredCats.

The queries used in the test are located in `src/test/resources/graphql-test` and can be run with
any tool, such as Insomnia or the IntelliJ Graphql plugin. For the IntelliJ plugin, the configuration
has already been created in the root of this repository (`graphql.config.yaml`).