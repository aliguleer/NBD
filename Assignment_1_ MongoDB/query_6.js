printjson(
db.people.insert(
{
  sex: 'Male',
  first_name: 'Ali',
  last_name: 'Güler',
  job: 'BI developer',
  email: 'aliguler@gmail.com',
  location: {
    city: 'Warsaw',
    address: { streetname: 'Choldna', streetnumber: '2' }
  },
  description: 'I dont know what will I write',
  height: '172',
  weight: '72',
  birth_date: '1979-02-22T11:51:38Z',
  nationality: 'Turkey',
  credit: [
   
    {
      type: 'visa-electron',
      number: '1231331312313',
      currency: 'PLN',
      balance: '75.25'
    }
      
  ]
})
);
