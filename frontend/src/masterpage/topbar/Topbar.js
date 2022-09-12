import css from "./Topbar.module.css"

function Topbar() {
    return (
    <div className={css.top_bar}>
    <div className={css.div1}>eHouse Keeping</div>
    <div className={css.div2}><div>Menu1</div><div>Menu2</div><div>Menu3</div><div>Menu4</div></div>
    <div className={css.div3}>eHouse Keeping</div>
    </div>
  );
}

export default Topbar;