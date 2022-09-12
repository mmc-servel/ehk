import css from "./Masterpage.module.css"
import Topbar from "./topbar/Topbar"

function Masterpage() {
    return (
    <div>
      <Topbar/>
      <div className={css.content}>
        <div className={css.login}></div>
      </div>
    </div>
  );
}

export default Masterpage;