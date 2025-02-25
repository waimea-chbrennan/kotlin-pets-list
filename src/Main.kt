/**
 * Pet Management Software \s
 * By Connor Brennan
 */


fun main() {
    val pets = mutableListOf<String>()

    while (true) {
        //Show current pets
        println("\nYou have ${pets.size} pet(s) currently: ")
        show(pets)
        println()
        //Ask for action (add, remove)
        val action = menu(listOf("Add a pet", "Delete a pet", "Quit"))
        //Act upon it
        when (action) {
            'q' -> break
            'd' -> deletePet(pets)
            'a' -> getNewPet(pets)
        }
    }

}

/**
 * Get New Pet
 */
fun getNewPet(pets: MutableList<String>) {
    val newPet = getString("New Pet: ")
    pets.add(newPet)
}


/**
 * Delete Pet
 */
fun deletePet(pets: MutableList<String>) {
    println("Type the name of a pet to delete or anything else to cancel")
    val input = getString("Pet to delete (case sensitive): ")
    pets.remove(input)
}

/**
 * Show option menu and get the user's choice.
 * Return this as char
 */
fun menu(options: List<String>): Char {
    options.forEach { option ->
        val formatted = StringBuilder(option)
        formatted.insert(0, "[")
        formatted.insert(2, "]")
        println("$formatted")
    }
    while(true) {
        print("Enter option: ")
        val input = readln()
        if (input.isBlank()) continue

        val choice = input.lowercase().first()
        if (options.any {it.startsWith(choice, ignoreCase = true)}) return choice
    }
}


/**
 * Show a given list with numbered entries (human-readable)
 */
fun show(list: List<Any>) {
    list.forEachIndexed { i, element ->
        println("${i+1}: $element")
    }
}


fun getString(prompt: String): String {
    var userInput: String

    while (true) {
        print(prompt)
        userInput = readln()
        if (userInput.isNotBlank()) break
        println("You cannot continue with this field")
    }

    return userInput
}