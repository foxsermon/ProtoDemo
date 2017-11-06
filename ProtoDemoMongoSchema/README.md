# Proto Demo Mongo Schema
Defines schema collections for Proto Demo Microservices or modules.

```
use protodemo;

db.permissions.insert({_id: 30, name: 'read all'});
db.permissions.insert({_id: 31, name: 'buy all'});
db.permissions.insert({_id: 32, name: 'read Home, Garden & Tools'});
db.permissions.insert({_id: 33, name: 'buy Home, Garden & Tools'});
db.permissions.insert({_id: 34, name: 'read Electronics, Computers & Office'});
db.permissions.insert({_id: 35, name: 'buy Electronics, Computers & Office'});

db.roles.insert({_id: 100, name: 'full access', created: new Date(), permissions: [{prmId: 30}, {prmId: 31}] });
db.roles.insert({_id: 101, name: 'full Home, Garden & Tools', created: new Date(), permissions: [{prmId: 32}, {prmId: 33}] });
db.roles.insert({_id: 102, name: 'read only Home, Garden & Tools', created: new Date(), permissions: [{prmId: 32}] });
db.roles.insert({_id: 103, name: 'full Electronics, Computers & Office', created: new Date(), permissions: [{prmId: 34}, {prmId: 35}] });
db.roles.insert({_id: 104, name: 'read only Electronics, Computers & Office', created: new Date(), permissions: [{prmId: 34}] });

db.users.insert({_id: -2, name: 'Aadmin', created: new Date(), roles:[ {roleId: 100} ] });
db.users.insert({_id: -1, name: 'Anonymous', created: new Date(), roles:[ {roleId: 102}, {roleId: 104} ] });
db.users.insert({_id: 10, name: 'Tomas Smith', email: 'tomas.smith@gmail.com', created: new Date(), roles:[ {roleId: 101}, {roleId: 103} ] });

// db.catalog.drop();
db.catalog.insert(
	{
		_id: 100000, 
		catalogName: 'Home, Garden & Tools', 
		created: new Date(),
		departments: [
			{
				deptId: 110000, 
				departmentName: 'Appliances', 
				created: new Date(),
				subdepartments: [
					{
						subdeptId: 111000, 
						subdepartmentName: 'Air Conditioners', 
						created: new Date(),
						products: [
							{
								prdId: 111001, 
								productName: 'Sturdy Covers AC Defender - Window Air Conditioner Unit Cover', 
								price: 234.23, 
								quantity: 10,
								created: new Date()
							},
							{
								prdId: 111002, 
								productName: 'Hotop Exhaust Hose for Portable Air Conditioner, 5.9 Inch Diameter Universal with Length 59 Inch', 
								price: 101.43, 
								quantity: 10,
								created: new Date()
							}
						]
					},
					{
						subdeptId: 112000, 
						subdepartmentName: 'Dishwashers', 
						created: new Date(),
						products: [
							{
								prdId: 112001, 
								productName: 'hOmeLabs Compact Countertop Dishwasher - Portable Mini Dish Washer in Stainless Steel Interior for Small Apartment Office and Home Kitchen - Dishwashers with 6 Place Setting Rack and Silverware Basket', 
								price: 201.44, 
								quantity: 10,
								created: new Date()
							},
							{
								prdId: 112002, 
								productName: 'SPT Countertop Dishwasher, White', 
								price: 40.44, 
								quantity: 10,
								created: new Date()
							}
						]
					}
				]
			}
		]
	}
);
db.catalog.insert(	
	{
		_id: 200000, 
		catalogName: 'Electronics, Computer & Office',
		created: new Date(),
		departments: [
			{
				deptId: 210000, 
				departmentName: 'Television & Video', 
				created: new Date(),
				subdepartments: [
					{
						subdeptId: 211000, 
						subdepartmentName: 'Televisions', 
						created: new Date(),
						products: [
							{
								prdId: 211001, 
								productName: 'Sony smart TV 45\'', 
								price: 305.99, 
								quantity: 10,
								created: new Date()
							},
							{
								prdId: 211002, 
								productName: 'GE smart TV 60\'', 
								price: 560.99, 
								quantity: 10,
								created: new Date()
							}
						]
					},
					{
						subdeptId: 212000, 
						subdepartmentName: 'Home Audio', 
						created: new Date(),
						products: [
							{
								prdId: 212001, 
								productName: 'Sony Best Audio ever', 
								price: 105.99, 
								quantity: 10,
								created: new Date()
							},
							{
								prdId: 212002, 
								productName: 'GE Ultra sound X', 
								price: 60.99, 
								quantity: 10,
								created: new Date()
							}
						]
					}
				]
			}
		]
	}
);



db.areas.aggregate([
	{
	  $lookup: {
	    from: "departments",
	    localField: "_id",
	    foreignField: "areaId",
	    as: "area_departments"
	  }
	},
	{
	  $unwind: "$area_departments"
	},
	{
	  $project: {
	    _id: "$_id",
	    areaName: "$name",
	    depId: "$area_departments._id",
	    depName: "$area_departments.name"
	  }
	},
	{
	  $lookup: {
	    from: "subdepartments",
	    localField: "depId",
	    foreignField: "depId",
	    as: "dep_subdeps"
	  }
	}, 
	{
	  $unwind: "$dep_subdeps"
	},
	{
	  $project: {
	    _id: "$_id",
	    areaName: "$areaName",
	    depId: "$depId",
	    depName: "$depName",
	    subdepId: "$dep_subdeps._id",
	    subdepName: "$dep_subdeps.name"
	  }
	}, 
	{
	  $lookup: {
	    from: "product",
	    localField: "subdepId",
	    foreignField: "subdepId",
	    as: "products"
	  }
	},
	{
	  $unwind: "$products"
	},
	{
	  $project: {
	    _id: 0,
	    areaId: "$_id",
	    areaName: "$areaName",
	    depId: "$depId",
	    depName: "$depName",
	    subdepId: "$dep_subdeps._id",
	    subdepName: "$dep_subdeps.name",
	    prodId: "$products._id",
	    prodName: "$products.name",
	    prodPrice: "$products.price"
	  }
	}	
]);


db.createView("productsView", "areas", [
	{
	  $lookup: {
	    from: "departments",
	    localField: "_id",
	    foreignField: "areaId",
	    as: "area_departments"
	  }
	},
	{
	  $unwind: "$area_departments"
	},
	{
	  $project: {
	    _id: "$_id",
	    areaName: "$name",
	    depId: "$area_departments._id",
	    depName: "$area_departments.name"
	  }
	},
	{
	  $lookup: {
	    from: "subdepartments",
	    localField: "depId",
	    foreignField: "depId",
	    as: "dep_subdeps"
	  }
	}, 
	{
	  $unwind: "$dep_subdeps"
	},
	{
	  $project: {
	    _id: "$_id",
	    areaName: "$areaName",
	    depId: "$depId",
	    depName: "$depName",
	    subdepId: "$dep_subdeps._id",
	    subdepName: "$dep_subdeps.name"
	  }
	}, 
	{
	  $lookup: {
	    from: "product",
	    localField: "subdepId",
	    foreignField: "subdepId",
	    as: "products"
	  }
	},
	{
	  $unwind: "$products"
	},
	{
	  $project: {
	    _id: 0,
	    areaId: "$_id",
	    areaName: "$areaName",
	    depId: "$depId",
	    depName: "$depName",
	    subdepId: "$dep_subdeps._id",
	    subdepName: "$dep_subdeps.name",
	    prodId: "$products._id",
	    prodName: "$products.name",
	    prodPrice: "$products.price"
	  }
	}	
]);

db.catalog.find();

```