// vars/greeting.groovy
def call(Map args = [name: "John", greeting: "Hello"]) {
    echo "${args.greeting} ${args.name}"
}
