import Masterpage from "./masterpage/Masterpage";
import Login from "./pages/login/Login";
import House from "./pages/house/House";
import { Route, Switch } from "react-router-dom";

let accounts = {
  table: {
    header: [
      {
        colname: "fullname",
        label: "Full Name",
        width: "45%",
        iskey: "N",
        ishidden: "N",
        valuelist: ["1", "2", "3"],
      },
      {
        colname: "profession",
        label: "User Activity",
        width: "45%",
        iskey: "N",
        ishidden: "N",
        valuelist: ["1", "2", "3"],
      },
      {
        colname: "id",
        label: "ID",
        width: "10%",
        iskey: "Y",
        ishidden: "Y",
        valuelist: ["a", "b", "c"],
      },
    ],
    data: [
      ["Sergiu Velescu", "Data Engineer", "1"],
      ["Vinaga Victor", "Data Engineer", "2"],
      ["Adrian-Donos Ivanovici", "Data Engineer abra ca dabra", "3"],
      ["Viorel Contu", "Java Developer", "4"],
    ],
  },
};

let solution={"sessionid":""};

function App() {
  return (
    <Masterpage>
      <Switch>
        {solution.sessionid === "" ? ( <Route path="/:p1" exact> <Login /> </Route>) : ( "" )}

        <Route path="/house">
          <House />
        </Route>       

      </Switch>
    </Masterpage>
  );
}

export default App;
