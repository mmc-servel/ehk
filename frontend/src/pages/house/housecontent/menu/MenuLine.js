
import menuline from "./MenuLine.module.css";



function MenuLine(props) {

  const onMenuItemClick = (rrr) =>
  {
    document.getElementsByClassName(menuline.menu_item_click)[0].className = menuline.menu_item_div;
    document.getElementById(rrr.currentTarget.id).className=menuline.menu_item_click;
    /*console.log(rrr.currentTarget.innerHTML);*/
    props.refreshContent(rrr.currentTarget.innerHTML.trim());
  }  

  return (
    <div className={menuline.menu_div} id="content_menu_div">  
      <div className={menuline.menu_item_click} onClick={onMenuItemClick.bind(this)} id="i1">  General </div> 
      <div className={menuline.menu_item_div} onClick={onMenuItemClick.bind(this)} id="i2">  Financiar </div> 
      <div className={menuline.menu_item_div} onClick={onMenuItemClick.bind(this)} id="i3">  Istoric </div>   
      <div className={menuline.menu_item_empty_div}> </div>
    </div>
  );
}

export default MenuLine;
