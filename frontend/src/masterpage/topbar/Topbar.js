import css from "./Topbar.module.css"
import { Link } from "react-router-dom";

function Topbar() {
    return (
    <div className={css.top_bar}>
    <div className={css.div1}>eHouse Keeping</div>
    <div className={css.div2}><div><Link to="/house">House</Link></div><div>Menu2</div><div>Menu3</div><div>Menu4</div><div>Menu5</div></div>
    <div className={css.div3}><Link to="/login">Log In</Link></div>
    </div>
  );
}

export default Topbar;