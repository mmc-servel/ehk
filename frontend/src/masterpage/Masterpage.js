import css from "./Masterpage.module.css"
import Topbar from "./topbar/Topbar"

function Masterpage(props) {
    return (
    <div>
      <Topbar/>
      <div className={css.content}>
           {props.children}
      </div>
    </div>
  );
}

export default Masterpage;