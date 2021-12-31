printjson(
db.people.aggregate(
   
   {
    "$group": {
        "_id": "$nationality",
        "BMI Avarage ": { "$avg": {
				"$divide":[
							{ $toDecimal: "$weight" },
								{"$multiply":[
											  {
												"$divide":[
												{ $toDecimal: "$height" },100 ]
												
												},
												 {
													"$divide":[
													{ $toDecimal: "$height" },100 ]
												
												}
												
											]
				
								}
						]
					}
			},
			
			   "BMI Max ": { "$max": {
				"$divide":[
							{ $toDecimal: "$weight" },
								{"$multiply":[
											  {
												"$divide":[
												{ $toDecimal: "$height" },100 ]
												
												},
												 {
													"$divide":[
													{ $toDecimal: "$height" },100 ]
												
												}
												
											]
				
								}
						]
					}
			},
			
			  "BMI Min ": { "$min": {
				"$divide":[
							{ $toDecimal: "$weight" },
								{"$multiply":[
											  {
												"$divide":[
												{ $toDecimal: "$height" },100 ]
												
												},
												 {
													"$divide":[
													{ $toDecimal: "$height" },100 ]
												
												}
												
											]
				
								}
						]
					}
			}
			
    }
}
).toArray()
);
