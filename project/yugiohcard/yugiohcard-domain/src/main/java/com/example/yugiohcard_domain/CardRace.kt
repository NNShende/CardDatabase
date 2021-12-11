@file:Suppress("unused")
package com.example.yugiohcard_domain

enum class CardRace(name: String) {
    // Monsters
    Aqua(name = "Aqua"),
    Beast(name = "Beast"),
    BeastWarrior(name = "Beast-Warrior"),
    CreatorGod(name = "Creator-God"),
    Cyberse(name = "Cyberse"),
    Dinosaur(name = "Dinosaur"),
    DivineBeast(name = "Divine-Beast"),
    Dragon(name = "Dragon"),
    Fairy(name = "Fairy"),
    Fiend(name = "Fiend"),
    Fish(name = "Fish"),
    Insect(name = "Insect"),
    Machine(name = "Machine"),
    Plant(name = "Plant"),
    Psychic(name = "Psychic"),
    Pyro(name = "Pyro"),
    Reptile(name = "Reptile"),
    Rock(name = "Rock"),
    SeaSerpent(name = "Sea Serpent"),
    Spellcaster(name = "Spellcaster"),
    Thunder(name = "Thunder"),
    Warrior(name = "Warrior"),
    WingedBeast(name = "Winged Beast"),

    // Spell/Trap
    Normal(name = "Normal"), // Both Spell and Trap cards can be this
    Field(name = "Field"),
    Equip(name = "Equip"),
    Continuous(name = "Continuous"), // Both Spell and Trap cards can be this
    QuickPlay(name = "Quick-Play"),
    Ritual(name = "Ritual"),
    Counter(name = "Counter"),

    Unknown("unknown"),
}

fun getCardRace(name: String): CardRace {
    val values = CardRace.values().toList()

    return values.find { it.name == name } ?: CardRace.Unknown
}
