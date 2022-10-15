import css from "./House.css";
import cssmodule from "./House.module.css";
import HouseNavi from "./housenavi/HouseNavi"
import HouseContent from "./housecontent/HouseContent"

function House(props) {
  return (
    <div className={cssmodule.top_div}>

      <HouseNavi/>
      <HouseContent/>

    </div>
  );
}

export default House;
