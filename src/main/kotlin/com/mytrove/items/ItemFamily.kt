package com.mytrove.items

import java.util.UUID

/**
 * An item Family is a named group of item types that have something in common. Item Family's are
 * useful for grouping Item Types inside a type picker UI.
 */
data class ItemFamily(

  /**
   * Database id.
   */
  val id: Long,

  /**
   * Image icon for the item family
   */
  val imageUrl: String,

  /**
   * Whether the item family is archived
   */
  val isArchived: Boolean,

  /**
   * Unique uuid for the family that can be hardcoded into scripts
   */
  val uuid: UUID,

  /**
   * Family category of the item
   */
  val category: ItemFamilyCategory
) {

  enum class BuiltIn constructor(
    val uuid: UUID,
    val strings: List<EntityStrings>,
    val imageUrl: String,
    val category: ItemFamilyCategory
  ) {

    RESIDENCE(
      UUID.fromString("28116889-2AEF-477E-B9F2-FAC5D37A7162"),
      listOf(
        EntityStrings(
          locale = "en",
          name =
          EntityName(
            generic = "Residence",
            singular = "Residence",
            plural = "Residences"
          ),
          alternateSearchStrings = listOf("House", "Home")
        )
      ),
      "https://trove.imgix.net/assets/inventory/house.png",
      ItemFamilyCategory.ROOM
    ),

    CHAIRS(
      UUID.fromString("FBE5D63D-FB3B-480E-A59A-5A9C7C9EC4E0"),
      listOf(
        EntityStrings(
          locale = "en",
          name =
          EntityName(
            generic = "Chair",
            singular = "Chair",
            plural = "Chairs"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      "https://trove.imgix.net/assets/inventory/dining-chair.png",
      ItemFamilyCategory.USE
    ),

    DINING_ROOM(
      UUID.fromString("CD503E39-20C0-4CEB-91F6-64F3D97DA2BC"),
      listOf(
        EntityStrings(
          locale = "en",
          name =
          EntityName(
            generic = "Dining Room",
            singular = "Dining Room",
            plural = "Dining Rooms"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      "https://trove.imgix.net/assets/inventory/dining-table.png",
      ItemFamilyCategory.ROOM
    );

    val debugName: String
      get() = this.strings.stream().findFirst().map({ s -> s.name.generic }).orElse("")
  }

}