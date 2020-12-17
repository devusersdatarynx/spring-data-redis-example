
Spring data redis database example with CRUD operation

POST
http://localhost:9292/product

{
    "id": 108,
    "name":"oppo",
    "qty":4,
    "price": 98000
}

DELETE
http://localhost:9292/product/108

Product removed !!!


GET
http://localhost:9292/product


    {
        "id": 108,
        "name": "oppo",
        "qty": 4,
        "price": 98000
    },
    {
        "id": 102,
        "name": "Nokia",
        "qty": 1,
        "price": 12000
    },
    {
        "id": 109,
        "name": "RedmI",
        "qty": 1,
        "price": 15000
    },
    {
        "id": 101,
        "name": "samsung",
        "qty": 2,
        "price": 4500
    }
]
