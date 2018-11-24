import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom';
import { Table } from 'reactstrap';
import '../webapp/css/custom.css';

class MainPage extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
            urlList: []
        }
	}

	componentDidMount() {
		fetch('/shortenURL/list', {
            method: 'GET'
        }).then(response => response.json())
        .then(data => {
            this.setState({urlList : data});           
        });
	}

    render() {
        return <div className="main">
			<Table>
				<thead>
					<th>Target URL</th>
					<th>Shorten URL</th>
				</thead>
				<tbody>
					{this.state.urlList.map(data => {
						return <tr>
							<td>{data.targetUrl}</td>
							<td><a href={data.shortenUrl}>{data.shortenUrl}</a></td>
						</tr>
					})}
				</tbody>
			</Table>
        </div>;
    }
 
}
 
ReactDOM.render(<MainPage/>, document.getElementById('root'));