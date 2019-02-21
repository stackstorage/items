package com.mytrove.items

import java.util.*

data class ItemType(

  /**
   * Database id.
   */
  val id: Long,

  /**
   * unique uuid for the type of item that can be hardcoded into scripts
   */
  val uuid: UUID,


  /**
   * category of the item
   */
  val category: ItemCategory,


  /**
   * approximate number of cubic feet for the item
   */
  val cubicFeetEstimate: Int,


  /**
   * true if this item type represents something that could be too big to fit in a vault.
   */
  val isPotentiallyOversized: Boolean,

  /**
   * image icon for the item type
   */
  val imageUrl: String,


  /**
   * whether this item type has been approved as canonical. This is necessary because
   * item types can be created by ops through the estimator (non-canonical) and we only want
   * movers to be able to select canonical item types in the mover app.
   */
  val isCanonical: Boolean,

  /**
   * whether the item type is archived
   */
  val isArchived: Boolean) {

  enum class BuiltIn(
    val uuid: UUID,
    val category: ItemCategory,
    val strings: List<EntityStrings>,
    val cubicFeetEstimate: Int,
    val imageUrl: String,
    val isCanonical: Boolean,
    val families: List<UUID>,
    val isPotentiallyOversize: Boolean) {

    STUDIO_RESIDENCE(
      UUID.fromString("0304EFB4-F3C9-4D19-A303-4D3A561FA7F2"),
      ItemCategory.RESIDENCE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Residence (Studio)",
            singular = "Residence (Studio)",
            plural = "Residences (Studio)"
          ),
          alternateSearchStrings = listOf("Studio Residence")
        )
      ),
      ItemTypeSizeConstants.studio,
      "https://trove.imgix.net/assets/inventory/apartment-building.png",
      true,
      listOf(ItemFamily.BuiltIn.RESIDENCE.uuid),
      true
    ),

    ONE_BEDROOM_RESIDENCE(
      UUID.fromString("270983B1-9ADB-4FAA-A070-E8FA59A30C68"),
      ItemCategory.RESIDENCE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Residence (1 Bedroom)",
            singular = "Residence (1 Bedroom)",
            plural = "Residences (1 Bedroom)"
          ),
          alternateSearchStrings = listOf(
            "One Bedroom Residence",
            "One BR Residence",
            "1 BR Residence"
          )
        )
      ),
      ItemTypeSizeConstants.oneBr,
      "https://trove.imgix.net/assets/inventory/house.png",
      true,
      listOf(ItemFamily.BuiltIn.RESIDENCE.uuid),
      true
    ),

    TWO_BEDROOM_RESIDENCE(
      UUID.fromString("C687DDC7-34A4-4382-8341-B23EC187E689"),
      ItemCategory.RESIDENCE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Residence (2 Bedroom)",
            singular = "Residence (2 Bedroom)",
            plural = "Residences (2 Bedroom)"
          ),
          alternateSearchStrings = listOf(
            "Two Bedroom Residence",
            "Two BR Residence",
            "2 BR Residence"
          )
        )
      ),
      ItemTypeSizeConstants.twoBr,
      "https://trove.imgix.net/assets/inventory/house.png",
      true,
      listOf(ItemFamily.BuiltIn.RESIDENCE.uuid),
      true
    ),

    THREE_BEDROOM_RESIDENCE(
      UUID.fromString("D2B701AD-387A-4F96-A788-1315F7D1996A"),
      ItemCategory.RESIDENCE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Residence (3 Bedroom)",
            singular = "Residence (3 Bedroom)",
            plural = "Residences (3 Bedroom)"
          ),
          alternateSearchStrings = listOf(
            "Three Bedroom Residence",
            "Three BR Residence",
            "3 BR Residence"
          )
        )
      ),
      ItemTypeSizeConstants.threeBr,
      "https://trove.imgix.net/assets/inventory/house.png",
      true,
      listOf(ItemFamily.BuiltIn.RESIDENCE.uuid),
      true
    ),

    FOUR_BEDROOM_RESIDENCE(
      UUID.fromString("74DF0122-CFD5-4CD5-BD7F-E15CDF1A89D8"),
      ItemCategory.RESIDENCE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Residence (4 Bedroom)",
            singular = "Residence (4 Bedroom)",
            plural = "Residences (4 Bedroom)"
          ),
          alternateSearchStrings = listOf(
            "Four Bedroom Residence",
            "Four BR Residence",
            "4 BR Residence"
          )
        )
      ),
      ItemTypeSizeConstants.fourBr,
      "https://trove.imgix.net/assets/inventory/house.png",
      true,
      listOf(ItemFamily.BuiltIn.RESIDENCE.uuid),
      true
    ),

    FIVE_BEDROOM_RESIDENCE(
      UUID.fromString("FE7893FB-9A22-4CD9-A607-B3F788B6FF76"),
      ItemCategory.RESIDENCE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Residence (5 Bedroom)",
            singular = "Residence (5 Bedroom)",
            plural = "Residences (5 Bedroom)"
          ),
          alternateSearchStrings = listOf(
            "Five Bedroom Residence",
            "Five BR Residence",
            "5 BR Residence"
          )
        )
      ),
      ItemTypeSizeConstants.fiveBr,
      "https://trove.imgix.net/assets/inventory/house.png",
      true,
      listOf(ItemFamily.BuiltIn.RESIDENCE.uuid),
      true
    ),

    SMALL_FURNITURE(
      UUID.fromString("9D012433-3365-4046-9671-21368EB3E441"),
      ItemCategory.FURNITURE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Small Furniture",
            singular = "Small Piece of Furniture",
            plural = "Small Pieces of Furniture"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      4,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      false
    ),

    MEDIUM_FURNITURE(
      UUID.fromString("7E48A28F-D551-4C2D-877F-5405186A19F4"),
      ItemCategory.FURNITURE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Medium Furniture",
            singular = "Medium Piece of Furniture",
            plural = "Medium Pieces of Furniture"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      16,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      false
    ),

    LARGE_FURNITURE(
      UUID.fromString("75C61D7F-5F0C-40AF-8212-F68E463499FB"),
      ItemCategory.FURNITURE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Large Furniture",
            singular = "Large Piece of Furniture",
            plural = "Large Pieces of Furniture"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      32,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      false
    ),

    EXTRA_LARGE_FURNITURE(
      UUID.fromString("E427E6A5-7923-44E3-A94B-2276F5C61715"),
      ItemCategory.FURNITURE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Extra Large Furniture",
            singular = "Extra Large Piece of Furniture",
            plural = "Extra Large Pieces of Furniture"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      64,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      true
    ),

    SMALL_OTHER(
      UUID.fromString("792391DE-9023-4184-A9B3-7ECFE6B3F9F0"),
      ItemCategory.OTHER,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Small Other",
            singular = "Small Other",
            plural = "Small Others"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      4,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      false
    ),

    MEDIUM_OTHER(
      UUID.fromString("4ECF9DC9-9821-490E-B23D-63762024D348"),
      ItemCategory.OTHER,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Medium Other",
            singular = "Medium Other",
            plural = "Medium Others"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      16,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      false
    ),

    LARGE_OTHER(
      UUID.fromString("70A90931-6931-466E-A838-7D14557E754C"),
      ItemCategory.OTHER,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Large Other",
            singular = "Large Other",
            plural = "Large Others"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      32,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      false
    ),

    EXTRA_LARGE_OTHER(
      UUID.fromString("589973F3-3630-46C4-B91C-BA74815B3219"),
      ItemCategory.OTHER,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Extra Large Other",
            singular = "Extra Large Other",
            plural = "Extra Large Others"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      64,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      true
    ),

    SMALL_ITEM(
      UUID.fromString("8D4F8322-ADC6-437A-83CD-DD332D0EF06B"),
      ItemCategory.UNKNOWN,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Small Item",
            singular = "Small Item",
            plural = "Small Items"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      4,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      false
    ),

    MEDIUM_ITEM(
      UUID.fromString("44643BF3-9A43-4AD3-8704-A16B6393EBF5"),
      ItemCategory.UNKNOWN,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Medium Item",
            singular = "Medium Item",
            plural = "Medium Items"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      16,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      false
    ),

    LARGE_ITEM(
      UUID.fromString("17009E60-E71E-43AB-958A-F6B3DDF33A91"),
      ItemCategory.UNKNOWN,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Large Item",
            singular = "Large Item",
            plural = "Large Items"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      32,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      false
    ),

    EXTRA_LARGE_ITEM(
      UUID.fromString("E5D06D75-D771-4BD5-811A-86DB5BDC7188"),
      ItemCategory.UNKNOWN,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Extra Large Item",
            singular = "Extra Large Item",
            plural = "Extra Large Items"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      64,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      true
    ),

    UNKNOWN_SIZED_BOX(
      UUID.fromString("1791D3E8-6C06-4F9E-9602-D85DCEDAD17E"),
      ItemCategory.BOX,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Unknown Sized Box",
            singular = "Unknown Sized Box",
            plural = "Unknown Sized Boxes"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      5,
      "https://trove.imgix.net/assets/inventory/box.png",
      true,
      listOf(),
      true
    ),

    UNKNOWN_SIZED_FURNITURE(
      UUID.fromString("6E0A80AC-0363-4C3A-86C7-24A3AEA95F8D"),
      ItemCategory.FURNITURE,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Unknown Sized Furniture",
            singular = "Unknown Sized Piece of Furniture",
            plural = "Unknown Sized Pieces of Furniture"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      32,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      true
    ),

    UNKNOWN_SIZED_OTHER(
      UUID.fromString("216C4EFA-F3AF-4FAB-B3ED-0E25AF3C4871"),
      ItemCategory.OTHER,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Unknown Sized Item",
            singular = "Unknown Sized Item",
            plural = "Unknown Sized Items"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      32,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      true
    ),

    UNKNOWN_SIZED_UNKNOWN(
      UUID.fromString("9357747F-DC18-4C9D-B3D0-A920AEAD15C5"),
      ItemCategory.UNKNOWN,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Unknown Sized Good",
            singular = "Unknown Sized Good",
            plural = "Unknown Sized Goods"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      32,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      true
    ),

    STORAGE_UNIT_SQFT(
      UUID.fromString("4F21D156-5327-4759-8BB9-328B53D4CE4B"),
      ItemCategory.OTHER,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "SQFT Storage Space",
            singular = "SQFT Storage Space",
            plural = "SQFT Storage Space"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      8,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      true,
      listOf(),
      true
    ),
    PLYWOOD_VAULT(
      UUID.fromString("D30296C9-DF59-4118-9755-E03D557A338E"),
      ItemCategory.OTHER,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Plywood Vault",
            singular = "Plywood Vault",
            plural = "Plywood Vaults"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      280,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      false,
      listOf(),
      true
    ),
    VAULT_CONTENTS(
      UUID.fromString("F95AB966-3881-44FD-A131-6EC23BB23378"),
      ItemCategory.OTHER,
      listOf(
        EntityStrings(
          locale = "en",
          name = EntityName(
            generic = "Vault Contents",
            singular = "Vault Contents",
            plural = "Vaults Contents"
          ),
          alternateSearchStrings = listOf()
        )
      ),
      280,
      "https://trove.imgix.net/assets/inventory/placeholder.png",
      false,
      listOf(),
      false
    )
  }
}

