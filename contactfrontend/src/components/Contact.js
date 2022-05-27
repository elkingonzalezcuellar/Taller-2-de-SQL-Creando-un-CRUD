import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';


const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));

export default function Contact() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[name,setName]=useState('')
    const[phoneNumber,setPhoneNumber]=useState('')
    const[email,setEmail]=useState('')
    const[dateOfBirth,setDateOfBirth]=useState('')
    const[idContact,deleteContact]=useState('')
    const[contacts,setContacts]=useState([])
    const classes = useStyles();

  const handleClick=(e)=>{
    e.preventDefault()
    const contact={name,phoneNumber,email,dateOfBirth}
    console.log(contact)
    fetch("http://localhost:8080/contacts/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      mode: 'cors',
      cache: 'default',
      body:JSON.stringify(contact)

  }).then(()=>{
    console.log("New Contact added")
  })
}
useEffect(()=>{
  fetch("http://localhost:8080/contacts/getAll")
  .then(res=>res.json())
  .then((result)=>{
    setContacts(result);
    console.log(result)
  }
)
},[])
const deleteClick=(e)=>{
  e.preventDefault()
  const idDelete=idContact
  console.log(idDelete)
  fetch("http://localhost:8080/contacts/delete/"+idDelete,{
    method:"DELETE",
    headers:{"Content-Type":"application/json"},
    mode: 'cors',
    cache: 'default',
    body:JSON.stringify(idDelete)

}).then(()=>{
  console.log("Contact Deleted")
})

}
  return (

    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Add Contact</u></h1>

    <form className={classes.root} noValidate autoComplete="off">
    
      <TextField id="outlined-basic" label="Contact Name" variant="outlined" fullWidth 
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Contact Phone" variant="outlined" fullWidth 
      value={phoneNumber}
      onChange={(e)=>setPhoneNumber(e.target.value)}
      />
      <TextField id="outlined-basic" label="Contact email" variant="outlined" fullWidth 
      value={email}
      onChange={(e)=>setEmail(e.target.value)}
      />
      <TextField id="outlined-basic" label="Contact Birthday" variant="outlined" fullWidth 
      value={dateOfBirth}
      onChange={(e)=>setDateOfBirth(e.target.value)}
      />
      <Button variant="contained" color="primary" onClick={handleClick}>
        Submit
      </Button>
    </form>
   
    </Paper>
    
    
    <Paper elevation={3} style={paperStyle}>
    <h1 style={{color:"red"}}><u>Delete Contact</u></h1>
      <form className={classes.root} noValidate autoComplete="off">
              <TextField id="outlined-basic" label="ID to Delete" variant="outlined" fullWidth 
      value={idContact}
      onChange={(e)=>deleteContact(e.target.value)}
      />
      <Button variant="contained" color="secondary" onClick={deleteClick}>
        Delete
      </Button> 
      </form>
    </Paper>
    <h1>Contacts</h1>
    <Paper elevation={3} style={paperStyle}>

      {(contacts.map(contact => (
        <Paper elevation={6} style={{margin:"10px",padding: "15px", textAlign:"left" }} key={contact.id}>
          Id:{contact.id}<br/>
          Name: {contact.name}<br/>
          Email:{contact.email}<br/>
          Date Of Birth:{contact.dateOfBirth}
        </Paper>
      ))) }


    </Paper>



    </Container>
  );
}