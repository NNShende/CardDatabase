@file:Suppress("unused")
package com.example.yugiohcard_domain

enum class CardRace(val raceName: String) {
    // Monsters
    Aqua(raceName = "Aqua"),
    Beast(raceName = "Beast"),
    BeastWarrior(raceName = "Beast-Warrior"),
    CreatorGod(raceName = "Creator-God"),
    Cyberse(raceName = "Cyberse"),
    Dinosaur(raceName = "Dinosaur"),
    DivineBeast(raceName = "Divine-Beast"),
    Dragon(raceName = "Dragon"),
    Fairy(raceName = "Fairy"),
    Fiend(raceName = "Fiend"),
    Fish(raceName = "Fish"),
    Insect(raceName = "Insect"),
    Machine(raceName = "Machine"),
    Plant(raceName = "Plant"),
    Psychic(raceName = "Psychic"),
    Pyro(raceName = "Pyro"),
    Reptile(raceName = "Reptile"),
    Rock(raceName = "Rock"),
    SeaSerpent(raceName = "Sea Serpent"),
    Spellcaster(raceName = "Spellcaster"),
    Thunder(raceName = "Thunder"),
    Warrior(raceName = "Warrior"),
    WingedBeast(raceName = "Winged Beast"),

    // Spell/Trap
    Normal(raceName = "Normal"), // Both Spell and Trap cards can be this
    Field(raceName = "Field"),
    Equip(raceName = "Equip"),
    Continuous(raceName = "Continuous"), // Both Spell and Trap cards can be this
    QuickPlay(raceName = "Quick-Play"),
    Ritual(raceName = "Ritual"),
    Counter(raceName = "Counter"),

    Unknown("unknown"),
}

fun getCardRace(name: String): CardRace {
    val values = CardRace.values().toList()
    return values.find { it.raceName == name } ?: CardRace.Unknown
}
