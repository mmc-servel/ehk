
import cssmodule from "./HouseContent.module.css";
import MenuLine from "./menu/MenuLine";
import General from "./contentdetails/General";
import Financial from "./contentdetails/Financial";
import { useState } from "react";

function HouseContent(props) {

  const [dummy, setDummy] = useState("General");
  function refreshContent(page_to_show) {
    setDummy(page_to_show);
    console.log(page_to_show); 
  }
  return (
    <div className="div_block_area" style={{ width: "40%" }} >  

    <MenuLine refreshContent={refreshContent} />

    { dummy === "General" ? <General/> : ""}     
    
    { dummy ==="Financiar" ? <Financial/> : ""}  
    
  </div>
  );
}

export default HouseContent;
