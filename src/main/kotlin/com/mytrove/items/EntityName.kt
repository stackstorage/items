package com.mytrove.items

/**
 * Encapsulates how an entity is named. Currently supports generic, singular and plural. In the
 * future, could support attributes of other languages such as grammatical gender. See
 * https://en.wikipedia.org/wiki/Mass_noun for a lesson in countable vs non-countable names.
 */
data class EntityName(
  /**
   * Generic form of the name (e.g. "Ski Equipment", "Queen Mattress")
   */
  val generic: String,

  /**
   * Singular form of the name (e.g. "1 Set of Ski Equipment", "1 Queen Mattress")
   */
  val singular: String,

  /**
   * Plural form of the name (e.g. "2 Sets of Ski Equipment", "2 Queen Mattresses")
   */
  val plural: String
)