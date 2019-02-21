package com.mytrove.items

/**
 * Strings for an Entity in a particular language.
 */
data class EntityStrings(

  /**
   * the language (see RFC 5646)
   */
  val locale: String,


  /**
   * the name of the entity in the specified locale
   */
  val name: EntityName,

  /**
   * alternative search strings for the entity in the specified locale
   */
  val alternateSearchStrings: List<String>
)