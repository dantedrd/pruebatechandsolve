import React from "react";

export const Pagination = ({ page,total, changePage }) => {
    if (total === 0) {
      return <div className="pull-right pagination">Not Content</div>;
    }
  
    return (
      <div className="pull-right pagination">
        <a
          className={page === 1 ? 'text-muted' : ''}
          onClick={() => {
            if (page > 1) {
              changePage(page - 9);
            }
          }}
        >
          Preview
        </a>{' '}
        |{' '}
        <a
          className={page === total ? 'text-muted' : ''}
          onClick={() => {
            if (page < total) {
              changePage(page + 9);
            }
          }}
        >
          Next
        </a>{' '}
        ({`${page} / ${total}`}) Total {total}
      </div>
    );
  };
  