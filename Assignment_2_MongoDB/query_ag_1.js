printjson(
db.people.aggregate(
   {
    "$group": {
        "_id": "$sex",
        "Average Height": { "$avg": { $toDecimal: "$height" } },
		"Average Weight": { "$avg": { $toDecimal: "$weight" } }
    }
}
).toArray()
);