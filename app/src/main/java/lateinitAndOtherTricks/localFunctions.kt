package lateinitAndOtherTricks

fun savePerson(person: Person) {
    if (person.name.isEmpty()) {
        throw IllegalArgumentException(
                "Cannot save person ${person.id}: Name is empty")
    }

    if (person.email.isNullOrEmpty()) {
        throw IllegalArgumentException(
                "Cannot save person ${person.id}: Email is empty")
    }

    // Save person to the database
}

fun savePersonV2(person: Person) {
    // local function
    fun validate(value: String?, fieldName: String) {
        if (value.isNullOrEmpty()) {
            throw IllegalArgumentException(
                    "Cannot save person ${person.id}: empty $fieldName")
        }
    }

    validate(person.name, "Name")
    validate(person.email, "Email")

    // Save person to the database
}