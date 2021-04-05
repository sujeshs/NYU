-- update columns is_parent_property, is_child_property and is_standalone_property
update stern.feed_ll84_bbl
set is_parent_property     =
        case
            when parent_property_id = property_id then 1
            else 0
            end,
    is_child_property      =
        case
            when parent_property_id = property_id then 0
            else 1
            end,
    is_standalone_property =
        case
            when parent_property_id like '%Standalone Property%' then 1
            else 0
            end;

